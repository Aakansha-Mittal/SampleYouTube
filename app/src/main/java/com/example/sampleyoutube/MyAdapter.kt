package com.example.sampleyoutube

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import de.hdodenhof.circleimageview.CircleImageView

class MyAdapter(val context: Fragment, val data: List<Video>) :
RecyclerView.Adapter<MyAdapter.MyViewHolder>()

{

    class MyViewHolder(var itemView : View)  : RecyclerView.ViewHolder(itemView) {
        val thumbnail : ImageView
        val profileChannel : CircleImageView
        val description : TextView
        val channelName : TextView
        val views : TextView

        init {
            thumbnail = itemView.findViewById(R.id.thumbnail)
            profileChannel = itemView.findViewById(R.id.profileChannel)
            description = itemView.findViewById(R.id.description)
            channelName = itemView.findViewById(R.id.channelName)
            views = itemView.findViewById(R.id.views)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {

        val video = data[position]

        //val channelImgBitmap = BitmapFactory.decodeFile(video.channelImg)
        //val thumbnailBitmap = BitmapFactory.decodeFile(video.thumbnail)


        holder.channelName.text = video.channelName
        holder.description.text = video.tittle
        holder.views.text = video.views
        holder.profileChannel.setImageResource(video.channelImg)
        holder.thumbnail.setImageResource(video.thumbnail)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}