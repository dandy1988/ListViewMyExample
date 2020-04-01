package dandy1988.list_view;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

// Названия создаются по схеме "ПрилагательноеСуществительное", т.е. правильно будет ListViewAdapter
class AdapterListView extends BaseAdapter {

    ArrayList<String> exampleArray = new ArrayList<>(); //Сделать Private
    public ArrayList<Boolean> selections = new ArrayList<>(); //Сделать Private
    private final int colorRed = Color.RED;
    private final int colorWhite = Color.WHITE;

    public AdapterListView(@NonNull ArrayList<String> array, @NonNull ArrayList<Boolean> select) {
        super();
        exampleArray = array;
        selections = select;
    }

    @Override
    public int getCount() {
        if (exampleArray == null) return 0;
        return exampleArray.size();
    }

    @Override
    public Object getItem(int position) {
        if (position <= exampleArray.size() - 1) return exampleArray.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        if (position <= exampleArray.size() - 1) return position + 1;
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tvItem.setText((String) getItem(position));
        if (selections.get(position).booleanValue() == true){
            convertView.setBackgroundColor(colorRed);
        }
        if (selections.get(position).booleanValue() == false){
            convertView.setBackgroundColor(colorWhite);
        }
        return convertView;
    }

    public void deleteItems(){
        for (int i = 0; i < selections.size(); i++) {
            if ((selections.get(i) != null)&&(selections.get(i) == true)){
                selections.remove(i);
                exampleArray.remove(i);
                i--; //Для чего эта операция?
            }
        }
    }

}
