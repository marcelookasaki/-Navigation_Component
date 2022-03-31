package com.br.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.br.navigationcomponent.databinding.FragmentPrimeiroBinding


class PrimeiroFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        /* DataBinding → em fragments a variável binding deve ser criada e o binding inicializado
            em cada um dos fragments, indicando o fragment dentro dos parâmetros do inflate  */
        val binding: FragmentPrimeiroBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_primeiro, container, false)

        /* Recebe a informação passada pelo StartFragment */
        val args = PrimeiroFragmentArgs.fromBundle(requireArguments())

        /* Apresenta mensagem utilizando a informação recebida no args */
        binding.tvPergunta.text = "Escolha o próximo fragmento ${args.nome}"

        binding.btnNextFP.setOnClickListener { view : View ->

            var opcaoSelecionada = binding.radioGroup.checkedRadioButtonId

            if(opcaoSelecionada != -1) {

                /* Navegar para segundo fragmento */
                if(opcaoSelecionada == R.id.rbFrag2) {
                    view.findNavController().navigate(R.id.action_primeiroFragment_to_segundoFragment)

                    /* Navegar para o terceiro fragmento */
                } else if (opcaoSelecionada == R.id.rbFrag3) {
                    view.findNavController().navigate(R.id.action_primeiroFragment_to_terceiroFragment)

                }
            } else {

                Toast.makeText(context, "Escolha uma opção.", Toast.LENGTH_SHORT).show()

            }


        }



        return binding.root
    }
}