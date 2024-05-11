package com.example.sampleyoutube

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter : MyAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView = view.findViewById(R.id.recyclerview)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title = mutableListOf<String>("Top 10 Gadgets You Must Have in 2024!", "Ultimate Comfort Food Recipes for Cozy Evenings",
            "Hidden Gems: Exploring Secret Destinations Around the World",
            "30-Minute Full Body Workout for Beginners", "Easy Home Décor Hacks Using Recycled Materials",
            "Mastering Watercolor Techniques: Beginner's Guide",
            "Mindfulness Meditation: Finding Peace in Nature",
            "Hilarious Pranks Gone Wrong Compilation" ,
            "Behind the Music: Exclusive Interview with Rising Star",
            "Summer Fashion Lookbook: Must-Have Trends for 2024")

        val channelImg = mutableListOf<Int>(R.drawable.channel1, R.drawable.channel2, R.drawable.channel3, R.drawable.channel4,
            R.drawable.channel5, R.drawable.channel6, R.drawable.channel7,
            R.drawable.channel8,R.drawable.channel9, R.drawable.channel10)

        val thumbnail = mutableListOf<Int>(R.drawable.thumbnail1, R.drawable.thumbnail2, R.drawable.thumbnail3,
            R.drawable.thumbnail4, R.drawable.thumbnail5, R.drawable.thumbnail6,
            R.drawable.thumbnail7, R.drawable.thumbnail8, R.drawable.thumbnail9,
            R.drawable.thumbnail10)

        val channelName = mutableListOf<String>("TechBytesToday", "FoodFusionDelights" ,
            "TravelTalesUnfolded", "FitnessFrenzyHQ", "DIYDreamscape" ,
            "ArtistryAlchemy", "NatureNurturers", "ComedyCrazeCentral" ,
            "MusicMingleMagazine", "FashionFiestaFab")

        val views = mutableListOf<String>("256k" , "190k" , "96k" , "634k" ,
            "991k" , "371k" , "513k" , "620k" , "245k" , "710k" )

        val videos = mutableListOf<Video>()

        for(i in 0..9) {
            videos.add(Video(title.get(i), channelName.get(i), views.get(i),
                 thumbnail.get(i), channelImg.get(i)))
        }


        adapter = MyAdapter(this, videos)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    /*object DatabaseConnector {
        private const val DB_URL = "jdbc:postgresql://localhost:5432/Youtube"
        private const val USER = "postgres"
        private const val PASSWORD = "#Aakansha123"

        fun fetchDataFromDatabase(): List<Video> {
            val videos = mutableListOf<Video>()
            var connection: Connection? = null
            try {
                connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)
                val statement = connection.createStatement()
                val resultSet = statement.executeQuery("SELECT * FROM videos")
                while (resultSet.next()) {
                    val title = resultSet.getString("title")
                    val description = resultSet.getString("description")
                    val channelImgPath = resultSet.getString("channel_img")
                    val thumbnailPath = resultSet.getString("thumbnail_path")
                    val views = resultSet.getString("views")
                    val channelName = resultSet.getString("channel-name")
                    val video = Video(title, channelName, description, views, thumbnailPath,  channelImgPath)
                    videos.add(video)

                    Log.d("DatabaseConnector", "Fetched video: $title")

                }
                resultSet.close()
                statement.close()
            } catch (e: SQLException) {
                e.printStackTrace()

                Log.e("DatabaseConnector", "Error fetching data from database: ${e.message}")


            } finally {
                connection?.close()
            }
            return videos
        }
    }*/


}