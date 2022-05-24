package com.example.taskfrog.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.taskfrog.R
import com.example.taskfrog.room.FrogList
import com.example.taskfrog.room.FrogListViewModel

class AddFragment : Fragment() {

    private lateinit var frogListViewModel: FrogListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        frogListViewModel = ViewModelProvider(this)[FrogListViewModel::class.java]

        view.findViewById<Button>(R.id.btn_add).setOnClickListener {
            insertNewList()
        }

        return view
    }

    private fun insertNewList() {
        val listName = view?.findViewById<EditText>(R.id.et_ListName)?.text.toString()

        if(inputExists(listName)){
            val tempFrogList = FrogList(0, listName)

            frogListViewModel.addFrogList(tempFrogList)

            Toast.makeText(requireContext(), "Added $listName List", Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please specify a List Name", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputExists(checking: String): Boolean {
        return !(TextUtils.isEmpty(checking))
    }

}