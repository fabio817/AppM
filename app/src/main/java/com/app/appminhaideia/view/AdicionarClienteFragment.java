package com.app.appminhaideia.view;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.app.appminhaideia.R;
import com.app.appminhaideia.controller.ClienteController;
import com.app.appminhaideia.model.Cliente;


public class AdicionarClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    TextView txtTitulo;

    EditText editNome;
    EditText editEmail;
    EditText editCpf;
    EditText editIdade;
    EditText editTelefone;
    EditText editCep;
    EditText editBairro;
    EditText editLogradouro;
    EditText editCidade;
    EditText editEstado;

    CheckBox ckbTermoDeUso;

    Button btnCancelar;
    Button btnSalvar;

    Cliente novoCliente;

    ClienteController clienteController;


    public AdicionarClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);

        inicializarComponentesDeLayout();

        escultarEventosDosBotoes();


        return view;
    }

    /**
     * metodo para inicializar os componentes
     * da tela/layout pra adicionar os clientes
     */
    private void inicializarComponentesDeLayout() {

        txtTitulo = view.findViewById(R.id.txtTitulo);
        txtTitulo.setText(R.string.novo_cliente);

        editNome = view.findViewById(R.id.editNome);
        editEmail = view.findViewById(R.id.editEmail);
        editCpf = view.findViewById(R.id.editCpf);
        editIdade = view.findViewById(R.id.editIdade);
        editTelefone = view.findViewById(R.id.editTelefone);
        editCep = view.findViewById(R.id.editCep);
        editBairro = view.findViewById(R.id.editBairro);
        editLogradouro = view.findViewById(R.id.editLogradouro);
        editCidade = view.findViewById(R.id.editCidade);
        editEstado = view.findViewById(R.id.editEstado);

        ckbTermoDeUso = view.findViewById(R.id.ckbTermoDeUso);

        btnCancelar = view.findViewById(R.id.btnCancelar);
        btnSalvar= view.findViewById(R.id.btnSalvar);

        novoCliente = new Cliente();

        clienteController = new ClienteController(getContext());

    }

    private void escultarEventosDosBotoes() {

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDadosOk = true;

                if(TextUtils.isEmpty(editNome.getText())){
                    isDadosOk = false;
                    editNome.setError("Digitar o Nome Completo:");
                    editNome.requestFocus();
                }

                if(TextUtils.isEmpty(editEmail.getText())){
                    isDadosOk = false;
                    editEmail.setError("Digitar o E-mail:");
                    editEmail.requestFocus();
                }
                if(TextUtils.isEmpty(editTelefone.getText())){
                    isDadosOk = false;
                    editTelefone.setError("Digitar o Telefone:");
                    editTelefone.requestFocus();
                }

                if(TextUtils.isEmpty(editCpf.getText())){
                    isDadosOk = false;
                    editCpf.setError("Digitar o CPF:");
                    editCpf.requestFocus();
                }

                if(TextUtils.isEmpty(editCidade.getText())){
                    isDadosOk = false;
                    editCidade.setError("Digitar a Cidade:");
                    editCidade.requestFocus();
                }

                if(isDadosOk){

                       clienteController.incluir(novoCliente);
                    Log.i("log_add_cliente", "onClick: tudo certo ao incluir os dados....");

                }else{
                    Toast.makeText(getContext(),"Digite os Campos Obrigatorios....",Toast.LENGTH_SHORT).show();
                    Log.i("log_add_cliente", "onClick: Erro ao incluir os dados....");
                }

            }
        });

    }


}
