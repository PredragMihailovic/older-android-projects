package com.example.johnny.chatbot.chat

import ai.api.AIConfiguration
import ai.api.AIListener
import ai.api.android.AIService
import ai.api.model.AIError
import ai.api.model.AIResponse
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageButton
import com.example.johnny.chatbot.Constant
import com.example.johnny.chatbot.R
import java.util.*

class ChatFragment : Fragment(), AIListener {

    private lateinit var sendButton: ImageButton
    private lateinit var inputText: EditText

    private var model = ChatViewModel()
    private var aiService: AIService? = null

    private lateinit var toolbar: Toolbar
    private lateinit var swipeToRefreshLayout: SwipeRefreshLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var recyclerViewManager: RecyclerView.LayoutManager

    private var listener: OnChatFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setAIService()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        model.messages.observe(this, Observer { list: MutableList<Message>? ->
            notifyAdapterDataSetChange()
        } )

        setViews(view)

        swipeToRefreshLayout.setOnRefreshListener {
            notifyAdapterDataSetChange()
        }

        sendButton.setOnClickListener{
            val messageBody = inputText.text.toString()

            if (messageBody != "") {
                addMessageToTheModel(messageBody)
            }
            clearInputText()
        }
        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if (context is ChatFragment.OnChatFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        if (id == android.R.id.home) {
            listener!!.popToHomeFragment()
        }
        return true
    }

    private fun setViews(view: View) {

        sendButton = view.findViewById(R.id.sendButton)
        inputText = view.findViewById(R.id.inputEditText)
        swipeToRefreshLayout = view.findViewById(R.id.swipeToRefresh)

        setToolbar(view)
        setRecyclerView(view)
    }

    private fun setToolbar(view: View){
        toolbar = view.findViewById(R.id.chatToolbar)

        setHasOptionsMenu(true)

        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar.apply {
            this!!.setDisplayHomeAsUpEnabled(true)
            this!!.setDisplayShowHomeEnabled(true)
        }
    }

    private fun clearInputText(){
        inputText.text.clear()
    }

    private fun addMessageToTheModel(messageBody: String){
        val message = Message(Sender(Constant.UserData.MY_USERNAME, Constant.UserData.MY_IMAGE_URL), MessageKind.SENDER,
                messageBody, Date())

        model.addMessage(message, aiService!!)
        notifyAdapterDataSetChange()
    }

    private fun notifyAdapterDataSetChange(){
        recyclerViewAdapter.notifyDataSetChanged()
        swipeToRefreshLayout.isRefreshing = false
    }

    private fun setAIService(){
        val config = ai.api.android.AIConfiguration(Constant.API_AI_KEY,
                AIConfiguration.SupportedLanguages.English,
                ai.api.android.AIConfiguration.RecognitionEngine.System)

        aiService = AIService.getService(activity, config)
        aiService?.setListener(this)
    }

    private fun setRecyclerView(view: View){
        recyclerViewManager = LinearLayoutManager(activity)
        recyclerViewAdapter = MessageListAdapter(model.messages.value as List<Message>, activity!!)
        recyclerView = view.findViewById<RecyclerView>(R.id.chatRecyclerView).apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager  = recyclerViewManager
        }
    }

    interface OnChatFragmentInteractionListener {
        fun popToHomeFragment()
    }

    companion object {
        fun newInstance(): Fragment = ChatFragment()
    }

    override fun onResult(result: AIResponse?) {
    }
    override fun onListeningStarted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onAudioLevel(level: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onError(error: AIError?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onListeningCanceled() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onListeningFinished() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}