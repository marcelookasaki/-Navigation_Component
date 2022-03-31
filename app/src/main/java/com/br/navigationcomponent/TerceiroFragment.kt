package com.br.navigationcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.br.navigationcomponent.databinding.FragmentTerceiroBinding


class TerceiroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentTerceiroBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_terceiro, container, false)

        /* Não deixa voltar para a tela anterior ao pressionar a função back */
        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            Toast.makeText(context, "Não é possível retornar a tela anterior", Toast.LENGTH_SHORT)
                .show()
        }

        /* Retorna para a StartFragment ao pressionar next */
        binding.btnNextFT.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_terceiroFragment_to_startFragment)
        }

        return binding.root
    }
}