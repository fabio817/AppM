package com.app.appminhaideia.controller;

import java.util.List;

public interface ICrud<T> {

    public Boolean incluir(T obj);

    public Boolean alterar(T obj);

    public Boolean deletar(T obj);

    public List<T> listar();

}
