package com.example.shopeelist

import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.*
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var itemList= arrayListOf<String>()
        var adapter= ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, itemList)

        var add=findViewById<ImageButton>(R.id.add)
        var clear=findViewById<ImageButton>(R.id.clear)
        var delete=findViewById<ImageButton>(R.id.delete)
        var addthing=findViewById<EditText>(R.id.addthing)
        var showlist=findViewById<ListView>(R.id.showlist)

        add.setOnClickListener()
        {
            itemList.add(addthing.text.toString())
            showlist.adapter= adapter
            adapter.notifyDataSetChanged()
            Toast.makeText(applicationContext, "Item Added to List", Toast.LENGTH_SHORT).show()
            addthing.text.clear()
        }

        delete.setOnClickListener()
        {
            val position:SparseBooleanArray=showlist.checkedItemPositions
            val count=showlist.count
            var item=count-1
            while (item>=0) {
                if (position.get(item)) {
                    adapter.remove(itemList.get(item))
                }
                item--
            }
                position.clear()
                Toast.makeText(applicationContext, "Selected Item is deleted from List", Toast.LENGTH_SHORT).show()
                adapter.notifyDataSetChanged()
            }


        clear.setOnClickListener()
        {
            itemList.clear()
            Toast.makeText(applicationContext, "List has been cleared", Toast.LENGTH_SHORT).show()
            adapter.notifyDataSetChanged()
        }



    }
}