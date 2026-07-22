package com.example.quizapp

import android.graphics.Color
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.data.Option

class OptionAdapter(
    private val options: List<Option>
) : RecyclerView.Adapter<OptionAdapter.OptionViewHolder>() {

    private var selectedPosition = -1
    private var isAnswerSubmitted = false
    private var selectedAnswerPosition = -1
    private var correctAnswerPosition = -1

     class OptionViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val tvOption = itemView.findViewById<TextView>(R.id.tv_option)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OptionAdapter.OptionViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_option,parent,false)

        return OptionViewHolder(view)

    }

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {
        val option = options[position]
        holder.tvOption.text = option.text
        if(!isAnswerSubmitted) {
            if (position == selectedPosition) {

                holder.tvOption.setBackgroundResource(R.drawable.selected_option_border_bg)
                holder.tvOption.setTextColor(Color.parseColor("#363A43"))
                holder.tvOption.setTypeface(holder.tvOption.typeface, Typeface.BOLD)

            } else {

                holder.tvOption.setBackgroundResource(R.drawable.default_option_border_bg)
                holder.tvOption.setTextColor(Color.parseColor("#7A8089"))
                holder.tvOption.setTypeface(holder.tvOption.typeface, Typeface.NORMAL)

            }

            holder.tvOption.setOnClickListener {
                if (isAnswerSubmitted) {
                    return@setOnClickListener
                }
                val currentPosition = holder.adapterPosition

                if (currentPosition != RecyclerView.NO_POSITION) {
                    selectedPosition = currentPosition
                    notifyDataSetChanged()
                }
            }
        }else {

            if (position == correctAnswerPosition) {

                holder.tvOption.setBackgroundResource(R.drawable.correct_option_border_bg)
                holder.tvOption.setTextColor(Color.parseColor("#363A43"))
                holder.tvOption.setTypeface(holder.tvOption.typeface, Typeface.BOLD)

            } else if (position == selectedAnswerPosition) {

                holder.tvOption.setBackgroundResource(R.drawable.wrong_option_border_bg)
                holder.tvOption.setTextColor(Color.parseColor("#363A43"))
                holder.tvOption.setTypeface(holder.tvOption.typeface, Typeface.BOLD)

            } else {

                holder.tvOption.setBackgroundResource(R.drawable.default_option_border_bg)
                holder.tvOption.setTextColor(Color.parseColor("#7A8089"))
                holder.tvOption.setTypeface(holder.tvOption.typeface, Typeface.NORMAL)

            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    fun getUserSelectedPosition(): Int{
        return selectedPosition
    }

    fun updateAnswerState(isAnswerSubmitted: Boolean, selectedAnswerPosition:Int, correctAnswerPosition:Int){
        this.isAnswerSubmitted = isAnswerSubmitted
        this.correctAnswerPosition = correctAnswerPosition
        this.selectedAnswerPosition = selectedAnswerPosition
        notifyDataSetChanged()
    }

}