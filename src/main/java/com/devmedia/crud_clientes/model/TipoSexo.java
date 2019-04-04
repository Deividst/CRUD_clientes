package com.devmedia.crud_clientes.model;

public enum TipoSexo {
    MASCULINO('M'),
    FEMININO('F');

    private char desc;

    TipoSexo(char desc) {
        this.desc = desc;
    }

    public char getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
