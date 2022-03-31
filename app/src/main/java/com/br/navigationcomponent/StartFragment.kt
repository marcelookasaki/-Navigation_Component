package com.br.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.br.navigationcomponent.databinding.FragmentStartBinding


class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* DataBinding → em fragments a variável binding deve ser criada e o binding inicializado
            em cada um dos fragments, indicando o fragment dentro dos parâmetros do inflate  */
        val binding: FragmentStartBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_start, container, false)



        binding.btnNextFragS.setOnClickListener {view : View ->

            if (binding.etNome.text.toString() != "") {



                /* Apenas navega para outro fragment */
                //view.findNavController().navigate(R.id.action_startFragment_to_primeiroFragment)

                var texto = binding.etNome.text.toString()

                /* Navega para outro fragment passando informação */
                view.findNavController().navigate(StartFragmentDirections.actionStartFragmentToPrimeiroFragment(texto))


            }

            /* Apenas navega para outro fragment */
            // binding.btnNextFragS.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_startFragment_to_primeiroFragment))
        }
    return binding.root
    }
}
