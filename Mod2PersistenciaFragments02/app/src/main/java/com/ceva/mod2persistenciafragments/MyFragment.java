package com.ceva.mod2persistenciafragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * El Fragment es una porcion grafica que deseamos tener en un activity
 */
public class MyFragment extends Fragment
{
    //definimos el metodo de creacion del fragment

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.myfragment, container, false);
        return view;
    }
    //luego de definir el fragment el sgte paso es pegar el fragment al activity
    /**
     * Para evitar la perdida de datos en los Activity fragments un truco es colocar el id en los objetos del layout y
     * asegurarnos que esos id sean unicos en toda la app.
     */

}
