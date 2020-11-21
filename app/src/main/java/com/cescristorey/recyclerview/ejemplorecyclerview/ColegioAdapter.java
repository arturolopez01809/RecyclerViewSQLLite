package com.cescristorey.recyclerview.ejemplorecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 23/10/2017.
 */

public class ColegioAdapter
        extends RecyclerView.Adapter<ColegioAdapter.ColegioViewHolder> {

    /*Arraylist donde almaceno los datos que se van a mostrar en el RecylerView*/
    private ArrayList<Colegio> datos;
    private final OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(Colegio item);
    }

    /* Incluyo el Viewholder en el Adapter */
    public static class ColegioViewHolder
            extends RecyclerView.ViewHolder {
        /* Como atributos se incluyen los elementos que van a referenciar a los elementos de la vista*/
        private TextView tvCod_colegio;
        private TextView tNombre;
        private TextView tvDireccion;

        /*constructor con parámetro de la vista*/
        public ColegioViewHolder(View itemView) {
            super(itemView);
            // Asocia los atributos a los widgets del layout de la vista
            tvCod_colegio = (TextView)itemView.findViewById(R.id.tvCod_colegio);
            tNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvDireccion = (TextView)itemView.findViewById(R.id.tvDireccion);
        }

        /*Muestra los datos de equipoFutbol en el item*/
        public void bindCoche(final Colegio colegio, final OnItemClickListener listener) {
            tvCod_colegio.setText(String.valueOf(colegio.getCod_colegio()));
            tNombre.setText(colegio.getNombre());
            tvDireccion.setText(colegio.getDireccion());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(colegio);
                }
            });


        }
    }


    /* Constructor con parámetros*/
    public ColegioAdapter(ArrayList<Colegio> datos, OnItemClickListener listener) {
        this.datos = datos;
        this.listener = listener;
    }

    @Override
    public ColegioViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        /*Crea la vista de un item y la "pinta"*/
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_coche, viewGroup, false);
        /* Crea un objeto de la clase EquipoViewHolder, pasándole la vista anteriormente creada*/
        ColegioViewHolder cocheVH = new ColegioViewHolder(itemView);
        /* devuelve la vissta*/
        return cocheVH;
    }

    @Override
    public void onBindViewHolder(ColegioViewHolder viewHolder, int pos) {
        Colegio colegio = datos.get(pos);
        /* Llama a bindCoche, para que "pinte" los datos del equipoFutbol que se le pasa como parámetro*/
        viewHolder.bindCoche(colegio, listener);
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }


}
