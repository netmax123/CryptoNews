package com.dvinasystems.cryptonews.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dvinasystems.cryptonews.databinding.FragmentCoinDetailsBinding

class CoinDetailsFragment : Fragment() {

    private val args by navArgs<CoinDetailsFragmentArgs>()
    private var _binding: FragmentCoinDetailsBinding? = null
    private val binding: FragmentCoinDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentCoinDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.coinName.text = args.coin.name
        binding.coinPrice.text = args.coin.currentPrice.toString()
    }
}