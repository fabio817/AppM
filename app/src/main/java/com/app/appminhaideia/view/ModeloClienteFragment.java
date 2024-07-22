package com.app.appminhaideia.view;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.app.appminhaideia.R;


public class ModeloClienteFragment extends Fragment {

    // Fragment - Classe responsável pela camada de VISÃO (Layout)
    View view;

    public ModeloClienteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view =  inflater.inflate(R.layout.fragment_cliente, container, false);

        TextView txtTitulo = view.findViewById(R.id.txtTitulo);

        txtTitulo.setText(R.string.modelo_fragment);

        // Trocar a cor da propriedade texto (setTextColor)
        txtTitulo.setTextColor(ColorStateList.valueOf(Color.CYAN));

        return view;
    }


}
