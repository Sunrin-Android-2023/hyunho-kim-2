package org.sunrin.sunrintemplate.main.world

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.sunrin.sunrintemplate.databinding.FragmentWorldBinding

class WorldFragment : Fragment() {
    private var mBinding : FragmentWorldBinding ?= null
    private val binding : FragmentWorldBinding get() = requireNotNull(mBinding)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentWorldBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}