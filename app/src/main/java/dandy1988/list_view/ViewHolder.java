package dandy1988.list_view;

import android.view.View;
import android.widget.TextView;

class ViewHolder {
    TextView tvItem;

    public ViewHolder(View view) {
        tvItem = (TextView) view.findViewById(R.id.tv_item);
    }
}
