package com.mjgl.basic_intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.mjgl.basic_intro.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText dato = view.findViewById(R.id.et_mensaje);


        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
                //Toast.makeText(getContext(), "Hola:"+R.id.action_FirstFragment_to_SecondFragment, Toast.LENGTH_SHORT).show();
            }
        });

        binding.btSaludo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = dato.getText().toString();
                if(dato.getText().length()==0){
                    Toast.makeText(view.getContext(), "Campo Obligatorio", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(view.getContext(), "Welcome: " + dato.getText().toString(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void Saludar(View view) {
        Toast.makeText(view.getContext(), "Hola mi gente", Toast.LENGTH_SHORT).show();
    }
}