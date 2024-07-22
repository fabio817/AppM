package com.app.appminhaideia.datamodel;

public class ClienteDataModel {

    // nome da tabela
    public static final String TABELA = "TabClientes";

    // nome na coluna na tabela AQUI TODOS são Strings
    public static final String ID = "id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String CPF = "cpf";
    public static final String IDADE = "idade";
    public static final String SEXO = "sexo";
    public static final String TELEFONE = "telefone";
    public static final String CEP = "cep";
    public static final String BAIRRO = "bairro";
    public static final String LOGRADOURO = "logradouro";
    public static final String CIDADE = "cidade";
    public static final String ESTADO = "estado";
    public static final String TERMOS_DE_USO = "termos_de_uso";

    // QUERY para criar a tabela no banco de dados
    public static String queryCriarTabela = "";

    // metodo para gerar script pra criar a tabela
    public static String criarTabela(){

        // concatenação de String

        queryCriarTabela += "create table "+TABELA+" (";
        queryCriarTabela += ID+" integer primary key autoincrement, ";
        queryCriarTabela += NOME+" text, ";
        queryCriarTabela += EMAIL+" text, ";
        queryCriarTabela += CEP+" text, ";
        queryCriarTabela += CPF+" text, ";
        queryCriarTabela += IDADE+" text, ";
        queryCriarTabela += SEXO+" integer, ";
        queryCriarTabela += TELEFONE+" text, ";
        queryCriarTabela += BAIRRO+" text, ";
        queryCriarTabela += LOGRADOURO+" text, ";
        queryCriarTabela += CIDADE+" text, ";
        queryCriarTabela += ESTADO+" text, ";
        queryCriarTabela += TERMOS_DE_USO+" integer ";
        queryCriarTabela += ")";


        return queryCriarTabela;
    }

}
