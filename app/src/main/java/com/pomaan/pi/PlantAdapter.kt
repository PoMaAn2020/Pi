package com.pomaan.pi

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.pomaan.pi.databinding.PlantItemBinding

class PlantAdapter: RecyclerView.Adapter<PlantAdapter.PlantHolder> {
    class PlantHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = PlantItemBinding.bind(item)
        fun bind(plant: Plant){

        }
    }
}