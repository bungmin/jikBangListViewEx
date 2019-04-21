package adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hh.jikbanglistviewex.R;

import java.util.List;

import datas.JikBang;

public class JikBangAdapter extends ArrayAdapter<JikBang> {
    Context mContext;
    List<JikBang> mList;
    LayoutInflater inf;


    public JikBangAdapter(Context context, List list) {
        super(context, R.layout.list_item_bang, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if(row == null){
            row = inf.inflate(R.layout.list_item_bang, null);
        }

        JikBang jikBang = mList.get(position);

        TextView bojengTxt = row.findViewById(R.id.bojeng);
        TextView payment_monthTxt = row.findViewById(R.id.payment_month);
        TextView floorTxt = row.findViewById(R.id.floor);
        TextView addrTxt = row.findViewById(R.id.addr);
        TextView descriongTxt = row.findViewById(R.id.descriong);


        bojengTxt.setText(String.format("%d",jikBang.bojeng));
        payment_monthTxt.setText(String.format("%d",jikBang.payment_month));
        floorTxt.setText(String.format("%d 층",jikBang.floor));
        addrTxt.setText(String.format("%s",jikBang.addr));
        descriongTxt.setText(String.format("%s",jikBang.descriong));

        return row;
    }
}
