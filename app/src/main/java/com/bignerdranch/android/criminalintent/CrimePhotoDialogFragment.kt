package com.bignerdranch.android.criminalintent

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.bignerdranch.android.criminalintent.databinding.FragmentCrimePhotoBinding
import java.io.File

class CrimePhotoDialogFragment : DialogFragment() {

    private val args: CrimePhotoDialogFragmentArgs by navArgs()

    private var _binding: FragmentCrimePhotoBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCrimePhotoBinding.inflate(inflater, container, false)
        binding.fullCrimePhoto.setImageBitmap(getPhotoFile(args.crimePhoto))
        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun getPhotoFile(photoFileName: String): Bitmap {
        val photoFile = File(requireContext().applicationContext.filesDir, photoFileName)
        return BitmapFactory.decodeFile(photoFile.path, BitmapFactory.Options())
    }
}