package com.devmedia.crud_clientes.converter;

import com.devmedia.crud_clientes.model.TipoSexo;
import org.springframework.core.convert.converter.Converter;

public class TipoSexoConverter implements Converter<String, TipoSexo> {
    @Override
    public TipoSexo convert(String source) {
        char tipo = source.charAt(0);
        return tipo == TipoSexo.FEMININO.getDesc() ? TipoSexo.FEMININO : TipoSexo.MASCULINO;
    }
}
