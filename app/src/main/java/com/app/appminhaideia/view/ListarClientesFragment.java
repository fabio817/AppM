package com.app.appminhaideia.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.appminhaideia.R;
import com.app.appminhaideia.controller.ClienteController;
import com.app.appminhaideia.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ListarClientesFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    TextView tituloPesquisar;


    EditText editPesquisa;


    ListView listaPesquisa;

    List<Cliente> clienteList;


    ArrayAdapter<String> clienteAdapter;
    ArrayList<HashMap<String, String>> fitroClientes;

    ClienteController clienteController;
    Cliente objCliente;



    public ListarClientesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_listar_clientes, container, false);

        TextView tituloPesquisar = view.findViewById(R.id.tituloPesquisar);

        tituloPesquisar.setText(R.string.listar_clientes);

        // Trocar a cor da propriedade texto (setTextColor)
        tituloPesquisar.setTextColor(ColorStateList.valueOf(Color.BLUE));



        clienteController = new ClienteController(getContext());

        listaPesquisa = (ListView) view.findViewById(R.id.listaPesquisa);
        editPesquisa =  view.findViewById(R.id.editPesquisa);


        clienteList = clienteController.listar();

        clienteController.gerarListaClientesView();
    /*    clientes = new ArrayList<>();

        // não se pode implementar a regra na camada da view
        // TODO: 23/07/2024 implementar regra de negocio na controladora da class Cliente

        for (Cliente obj: clienteList) {

            clientes.add(obj.getId()+", "+obj.getNome());

        }
*/
        clienteAdapter = new ArrayAdapter<>(getContext(), R.layout.listar_cliente_item, R.id.txtItemLista, clienteController.gerarListaClientesView());
        listaPesquisa.setAdapter(clienteAdapter);

        editPesquisa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence filtro, int i, int i1, int i2) {
/*
                ListarClientesFragment.this.clienteAdapter.getFilter().filter(filtro);

                Log.i("add_list_view", "beforeTextChanged: "+filtro);*/

            }

            @Override
            public void onTextChanged(CharSequence filtro, int i, int i1, int i2) {

                ListarClientesFragment.this.clienteAdapter.getFilter().filter(filtro);

                Log.i("add_list_view", "beforeTextChanged: "+filtro);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return view;
    }

}
