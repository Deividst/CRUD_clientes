package com.devmedia.crud_clientes.controller;

import com.devmedia.crud_clientes.dao.UsuarioDAO;
import com.devmedia.crud_clientes.model.TipoSexo;
import com.devmedia.crud_clientes.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    private UsuarioDAO dao;

    @Autowired
    public UsuarioController(UsuarioDAO dao) {
        this.dao = dao;
    }

    @ModelAttribute("sexos")
    public TipoSexo[] tipoSexos(){
        return TipoSexo.values();
    }

    @RequestMapping( value = "/todos", method = RequestMethod.GET)
    public ModelAndView listAll(ModelMap model){
        model.addAttribute("usuarios", dao.getAll());
        return new ModelAndView("/user/list", model);
    }

    @GetMapping("/sexo")
    public ModelAndView listarPorSexo(@RequestParam(value = "tipoSexo") TipoSexo sexo){

        if(sexo == null){
            return new ModelAndView("redirect:/usuario/todos");
        }
        return new ModelAndView("/user/list", "usuarios", dao.getBySexo(sexo));
    }

    @GetMapping("/nome")
    public ModelAndView listarPorNome(@RequestParam(value = "nome") String nome) {

        if (nome == null) {
            return new ModelAndView("redirect:/usuario/todos");
        }
        return new ModelAndView("/user/list", "usuarios", dao.getByNome(nome));
    }

    @GetMapping("/cadastro")
    public String cadastro(@ModelAttribute("usuario")Usuario usuario, ModelMap modelMap){
        return "/user/add";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("usuario")Usuario usuario, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/user/add";
        }
        dao.salvar(usuario);
        attributes.addFlashAttribute("message", "Usuário cadastrado com sucesso.");
        return "redirect:/usuario/todos";
    }

    @GetMapping("/update/{id}")
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
        Usuario usuario = dao.getId(id);
        model.addAttribute("usuario", usuario);
        return new ModelAndView("/user/add", model);
    }

    @PostMapping("/update")
    public ModelAndView update(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            return new ModelAndView("/user/add");
        }
        dao.editar(usuario);
        attr.addFlashAttribute("message", "Usuário alterado com sucesso.");
        return new ModelAndView("redirect:/usuario/todos");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
        dao.excluir(id);
        attr.addFlashAttribute("message", "Usuário excluído com sucesso.");
        return "redirect:/usuario/todos";
    }
}
