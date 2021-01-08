package com.dvinasystems.cryptonews.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.dvinasystems.cryptonews.BaseApplication
import com.dvinasystems.cryptonews.databinding.FragmentCoinsBinding
import com.dvinasystems.cryptonews.utils.RequestState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinsFragment : Fragment() {

    private var _binding: FragmentCoinsBinding? = null
    private val binding: FragmentCoinsBinding get() = _binding!!
    private val viewModel: CoinsViewModel by viewModels()

    @Inject
    lateinit var applicationContext: BaseApplication

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.refresh.setOnClickListener {
            Toast.makeText(requireContext(), "CoinGecko API is updated every 1 to 10 minutes", Toast.LENGTH_SHORT).show()
            viewModel.request()
        }

        viewModel.coins.observe(viewLifecycleOwner, {
            when (it) {
                is RequestState.Loading -> binding.progressBar.visibility = View.VISIBLE
                is RequestState.Success -> {
                    binding.recyclerView.adapter = CoinAdapter(it.body, applicationContext)
                    binding.progressBar.visibility = View.GONE
                }
            }
        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}