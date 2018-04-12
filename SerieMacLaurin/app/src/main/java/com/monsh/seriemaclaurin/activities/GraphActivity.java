package com.monsh.seriemaclaurin.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.monsh.seriemaclaurin.R;
import com.softmoore.android.graphlib.Function;
import com.softmoore.android.graphlib.Graph;
import com.softmoore.android.graphlib.GraphView;


public class GraphActivity extends AppCompatActivity {
    double ax, bx, cx,dx,e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Bundle extras = getIntent().getExtras();
        double ecuation[] =  extras.getDoubleArray("Function Values");

        ax = ecuation[0];
        Toast.makeText(this, String.valueOf(ax), Toast.LENGTH_SHORT).show();
        bx = ecuation[1];
        Toast.makeText(this, String.valueOf(bx), Toast.LENGTH_SHORT).show();
        cx = ecuation[2];
        Toast.makeText(this, String.valueOf(cx), Toast.LENGTH_SHORT).show();
        dx = ecuation[3];
        Toast.makeText(this, String.valueOf(dx), Toast.LENGTH_SHORT).show();
        e = ecuation[4];
        Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();


        Graph graph = new Graph.Builder()
                .addFunction(xQuadrathic, Color.RED)
                .setXTicks(new double[] {-18,-17,-16,-15,-14,-13,-12,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18})
                .setYTicks(new double[] {-18,-17,-16,-15,-14,-13,-12,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18})
                .build();
        GraphView graphView = findViewById(R.id.graph_view);
        graphView.setGraph(graph);
        setTitle("Empty Graph");
        TextView textView = findViewById(R.id.graph_view_label);
        textView.setText("Graph of Axes");

    }
    Function xQuadrathic = new Function(){
        public double apply(double x) {
            //return Math.pow(ax,4)+Math.pow(bx,3)+Math.pow(cx,2)+Math.pow(dx,1)+e;
            return bx*bx*bx;
        }
    };

}
