package mx.tecnm.tepic.ladm_u2_p1_semaforo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import com.google.android.material.internal.FlowLayout
import java.util.concurrent.Semaphore

class Carro(l:Lienzo,left:Float,top:Float,right:Float,boton:Float,col:String) {
    var l =l
    var p = Paint()
    var col =col
    var leftx = left
    var rightx = right
    var top = top
    var boton = boton

    fun pintarCarro(c:Canvas,transx:Float,transy:Float){
        p.setColor(Color.parseColor(col))
        c.drawRect(leftx+transx,top+transy,rightx+transx,boton+transy,p)
        if (col=="Blue" && (top+l.transY>=2300f)){
            l.transY=0f
        }
        if (col=="CYAN" && (leftx+l.transX2>=1300f)){
            l.transX2=0f

        }
        if(col=="Red" && (top+l.transY2<=-300f)){
            l.transY2=0f

        }
        if(col=="Yellow" && (leftx+l.transX<=-380f)){
            l.transX=0f
        }

    }

}


class Hilox(activity:Lienzo):Thread(){
    var act = activity
    override fun run() {
        super.run()
        while (true){
            //yellow
            if(!act.semaV &&  ((1050f+act.transX)>=780f && (1050f+act.transX)<=825f) )
            {}else{ act.transX-=act.velX+7}

            //azul-
            if(!act.semaH &&  (act.transY>=380f && act.transY<=410f) )
            {}else{act.transY+=act.velY}

            //red  1150
            if(!act.semaH &&  ((act.transY2)>=-635f && (act.transY2)<=-600f))
            {}else{ act.transY2-=(act.velY+15)}

            //cyan -
            if(!act.semaV &&  (act.transX2>=290f && act.transX2<=330f) )
            {}else{ act.transX2+=act.velX}

            sleep(100)
            }

        }//while
}

