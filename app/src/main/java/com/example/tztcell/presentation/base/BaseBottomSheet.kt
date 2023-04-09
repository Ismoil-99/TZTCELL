package com.example.tztcell.presentation.base

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

abstract class BaseBottomSheet<Binding : ViewBinding>(
    @LayoutRes private val layoutId: Int,
    private val bottomSheetBehaviorState: Int,
) : BottomSheetDialogFragment() {

    protected abstract val binding: Binding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.setOnShowListener {
            setupBottomSheetBackgroundTransparent(it)
            setupBottomSheetBehaviorState(it, bottomSheetBehaviorState)
        }
        return dialog
    }

    private fun setupBottomSheetBehaviorState(
        dialogInterface: DialogInterface,
        bottomSheetBehaviorState: Int
    ) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet =
            bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?
        BottomSheetBehavior.from<FrameLayout?>(bottomSheet!!).state = bottomSheetBehaviorState
    }

    private fun setupBottomSheetBackgroundTransparent(dialogInterface: DialogInterface) {
        val bottomSheetDialog = dialogInterface as BottomSheetDialog
        val bottomSheet = bottomSheetDialog.findViewById<View>(
            com.google.android.material.R.id.design_bottom_sheet
        ) ?: return

        bottomSheet.setBackgroundColor(Color.WHITE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialize()
        setupListeners()
    }

    protected open fun initialize() {
    }

    protected open fun setupListeners() {
    }
}
