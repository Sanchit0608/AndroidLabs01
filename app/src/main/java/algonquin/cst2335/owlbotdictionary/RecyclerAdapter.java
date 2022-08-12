package algonquin.cst2335.owlbotdictionary;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    Context context;
    List<String> data;
    String val;
    JSONArray defsArray;


    public RecyclerAdapter(List<String> data, JSONObject obj, Context context) {

        this.data = data;

        try {
            defsArray = (JSONArray) obj.get("definitions");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        this.context = context;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {//implements View.OnClickListener{

        Context mContext;
        TextView textView;

        public ViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.mContext = context;
            textView = itemView.findViewById(R.id.textNames);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_itemview, parent, false);
        return new ViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        val = data.get(position);
        holder.textView.setText(val);
        holder.textView.setOnClickListener(v -> {

            if (defsArray != null) {
                try {
                    Intent intent = new Intent(context, Information.class);

                    JSONObject obj = (JSONObject) defsArray.get(position);

                    String def = obj.getString("definition");
                    String type = obj.getString("type");
                    String example = obj.getString("example");

                    intent.putExtra("def", def);
                    intent.putExtra("type", type);
                    intent.putExtra("example", example);

                    context.startActivity(intent);

                } catch (JSONException e) {
                    Toast.makeText(context, "Some error occurred.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(context, "Try again later.", Toast.LENGTH_SHORT).show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}