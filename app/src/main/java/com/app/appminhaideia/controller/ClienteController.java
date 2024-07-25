package com.app.appminhaideia.controller;

import android.content.ContentValues;
import android.content.Context;

import com.app.appminhaideia.datamodel.ClienteDataModel;
import com.app.appminhaideia.dataresource.AppDataBase;
import com.app.appminhaideia.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteController extends AppDataBase implements ICrud<Cliente>{

    // recebendo os metodos e mandando pra Database
    ContentValues dadoDoObjeto;

    public ClienteController(Context context) {
        super(context);
    }


    @Override
    public Boolean incluir(Cliente obj) {

        // tranfomando os dados pra mandar
        dadoDoObjeto = new ContentValues();

        // passar key e valor

        // pegar o nome na coluna da tabela pra salvar o valor
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CPF, obj.getCpf());
        dadoDoObjeto.put(ClienteDataModel.IDADE, obj.getIdade());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermoDeUso());


        // enviar os dados (dadoDoObjeto) para a classe AppDataBase
        // utilizando metodo capaz de adicionar o OBJ no banco de dados
        // pra qualquer tabela
        // mais nesse caso aqui é pra (Cliente)

        return inserir(ClienteDataModel.TABELA, dadoDoObjeto);
    }

    @Override
    public Boolean alterar(Cliente obj) {

        // tranfomando os dados pra mandar
        dadoDoObjeto = new ContentValues();

        // passar key e valor

        // pegar o nome na coluna da tabela pra salvar o valor
        dadoDoObjeto.put(ClienteDataModel.ID, obj.getId());
        dadoDoObjeto.put(ClienteDataModel.NOME, obj.getNome());
        dadoDoObjeto.put(ClienteDataModel.EMAIL, obj.getEmail());
        dadoDoObjeto.put(ClienteDataModel.CPF, obj.getCpf());
        dadoDoObjeto.put(ClienteDataModel.IDADE, obj.getIdade());
        dadoDoObjeto.put(ClienteDataModel.TELEFONE, obj.getTelefone());
        dadoDoObjeto.put(ClienteDataModel.CEP, obj.getCep());
        dadoDoObjeto.put(ClienteDataModel.BAIRRO, obj.getBairro());
        dadoDoObjeto.put(ClienteDataModel.LOGRADOURO, obj.getLogradouro());
        dadoDoObjeto.put(ClienteDataModel.CIDADE, obj.getCidade());
        dadoDoObjeto.put(ClienteDataModel.ESTADO, obj.getEstado());
        dadoDoObjeto.put(ClienteDataModel.TERMOS_DE_USO, obj.isTermoDeUso());


        // enviar os dados (dadoDoObjeto) para a classe AppDataBase
        // utilizando metodo capaz de alterar o OBJ no banco de dados
        // pra qualquer tabela respeitando o ID
        // mais nesse caso aqui é pra (Cliente)

        // vem la da AppDataBase
        return upDate(ClienteDataModel.TABELA,dadoDoObjeto);
    }

    @Override
    public Boolean deletar(int id) {

        return deleteByID(ClienteDataModel.TABELA,id);
    }

    @Override
    public List<Cliente> listar(){

        return getAllClientes(ClienteDataModel.TABELA);
    }

    public List<String> gerarListaClientesView() {

        List<String> clientes = new ArrayList<>();

        for (Cliente obj: listar()) {

            clientes.add(obj.getId()+", "+obj.getNome());

        }

        return clientes;

    }
}
