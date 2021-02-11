package com.example.practica123;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.practica123.R;

import java.util.ArrayList;
public class TareasRecyclerViewAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // Array de items a mostrar en el RecyclerView
    private ArrayList<String> items;
    //Formato de letra en "negrilla"
    Typeface fontBold;
    Context mContext;
    //Constantes para controlar la ubicacion del titulo y de los items
    private final int ITEM = 0, TITLE = 1;
    // Constructor donde se pasan los items y el contexto
    public TareasRecyclerViewAdapter(Context context, ArrayList<String> items) {
        this.mContext = context;
        this.items = items;
    }
    //Función para obtener el tamaño de la lista
    @Override
    public int getItemCount() {
        return this.items.size();
    }
    //Tipo de vista a mostrar según la posición del item
    //Para este ejemplo, en la posición 0 se ubicará el titulo del recycler view
    //y los items en el resto de posiciones.
    //Recuerde que las lista, arrays, y elementos de tipo lista como el recycler view empiezan
    // el conteo de sus items por 0
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TITLE;
        } else {
            return ITEM;
        }
    }
    /**
     * Método para crear los diferentes Holders según el tipo de vista
     *
     * @param viewGroup ViewGroup container del item
     * @param viewType tipo de vista
     * @return viewHolder que se inflará
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        switch (viewType) {
            case ITEM:
                View v1 = inflater.inflate(R.layout.recycler_item, viewGroup, false);
                viewHolder = new ViewHolderItem(v1);
                break;
            case TITLE:
                View v2 = inflater.inflate(R.layout.recycler_title, viewGroup, false);
                viewHolder = new ViewHolderTitulo(v2);
                break;
            default:
                break;
        }
        return viewHolder;
    }
    /**
     * Este método llama internamente a onBindViewHolder(ViewHolder, int) para
     actualizar
     * el contenido de RecyclerView.ViewHolder con el item en esa posición
     * y setea los campos privados necesarios en el RecyclerView.
     *
     * @param viewHolder Tipo de RecyclerView.ViewHolder para rellenar
     * @param position posición del item
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case ITEM:
                ViewHolderItem vh1 = (ViewHolderItem) viewHolder;
                configureViewHolderTitulo(vh1, position);
                break;
            case TITLE:
                ViewHolderTitulo vh2 = (ViewHolderTitulo) viewHolder;
                configureViewHolderItem(vh2, position);
                break;
        }
    }
    private void configureViewHolderTitulo(ViewHolderItem vh1, int position) {
        String task = items.get(position);
        if (task != null) {
            switch (task) {
                case "CAPITAN AMÉRICA 1":
                    vh1.getTaskName().setText("CAPITAN AMÉRICA 1");
                    vh1.getTextStatus().setText("XD");
                    break;
                case "CAPITAN AMÉRICA 2":
                    vh1.getTaskName().setText("JENNIFER");
                    vh1.getTextStatus().setText("DEJA DE ESTRESARTE NO VA A TOMAR ESO");
                    break;
            }
        }
    }
    private void configureViewHolderItem(ViewHolderTitulo vh2, int position) {
        String separatorString = items.get(position);
        vh2.getTextViewSeparator().setText(separatorString);
        vh2.getTextViewSeparator().setTypeface(fontBold);
    }
    public class ViewHolderItem extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private TextView TextViewNombreTarea, TextViewEstadoTarea;
        public ViewHolderItem(View v) {
            super(v);
            TextViewNombreTarea = (TextView) v.findViewById(R.id.task_name);
            TextViewEstadoTarea = (TextView) v.findViewById(R.id.task_status);
            v.setOnClickListener(this);
        }
        public TextView getTaskName() {
            return TextViewNombreTarea;
        }
        public void setTaskName(TextView label1) {
            this.TextViewNombreTarea = label1;
        }
        public TextView getTextStatus() {
            return TextViewEstadoTarea;
        }
        public void setTextStatus(TextView textView) {
            this.TextViewEstadoTarea = textView;
        }
        @Override
        public void onClick(View view) {
            // obtiene la posición del item
            int position = getLayoutPosition();
        }
    }
    //Con el objeto View Holder básicamente lo que se consigue es evitar utilizar el método findViewById()
    // cada vez que se tenga que mostrar un nuevo elemento de la lista
    public class ViewHolderTitulo extends RecyclerView.ViewHolder {
        private TextView TextViewTitulo;
        public ViewHolderTitulo(View v) {
            super(v);
            TextViewTitulo = v.findViewById(R.id.separator);
        }
        public TextView getTextViewSeparator() {
            return TextViewTitulo;
        }
        public void setTextViewSeparator(TextView separator) {
            this.TextViewTitulo = separator;
        }
    }
}
