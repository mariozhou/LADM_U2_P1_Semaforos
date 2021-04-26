package mx.tecnm.tepic.ladm_u2_p1_semaforo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import java.util.concurrent.Semaphore

class Lienzo(p:MainActivity) : View(p) {
    var semaV = false
    var semaH = false
    var velX = 15f
    var velY = 15f
    var transX2 = 0f
    var transY2 = 0f
    var transX = 0f
    var transY = 0f
    var active = true
    var sema = Semaforo(this)
    var hilo = Hilox(this)

    //1080x2220
    var carrox1 = Carro(this,1050f,600f,1200f,740f,"Yellow")
    var carrox2 = Carro(this,-200f,900f,-50f,1040f,"CYAN")

    var carroy1 = Carro(this,320f,0f,460f,150f,"Blue")
    var carroy2 = Carro(this,580f,1750f,720f,1900f,"Red")

    var c1 = "Red"
    var c2 = "Black"
    var c3 = "Black"

    var e1 = "Red"
    var e2 = "Black"
    var e3 = "Black"

    override fun onDraw(c: Canvas) {

        super.onDraw(c)
        val p = Paint()

        p.setColor(Color.parseColor(c1))
        c.drawCircle(120f, 100f, 35f, p)
        p.setColor(Color.parseColor(c2))
        c.drawCircle(120f, 180f, 35f, p)
        p.setColor(Color.parseColor(c3))
        c.drawCircle(120f, 260f, 35f, p)

        p.setColor(Color.parseColor(e1))
        c.drawCircle(950f, 1300f, 35f, p)
        p.setColor(Color.parseColor(e2))
        c.drawCircle(950f, 1380f, 35f, p)
        p.setColor(Color.parseColor(e3))
        c.drawCircle(950f, 1460f, 35f, p)

        //1080x2220
        p.color = Color.GRAY//vert
        c.drawRect(300f,0f,800f,2222f,p)
        p.color = Color.WHITE
        c.drawRect(525f,10f,565f,90f,p)
        c.drawRect(525f,130f,565f,210f,p)
        c.drawRect(525f,250f,565f,330f,p)
        c.drawRect(525f,370f,565f,480f,p)

        c.drawRect(525f,1160f,565f,1260f,p)
        c.drawRect(525f,1280f,565f,1380f,p)
        c.drawRect(525f,1400f,565f,1500f,p)
        c.drawRect(525f,1520f,565f,1620f,p)
        c.drawRect(525f,1640f,565f,1740f,p)
        c.drawRect(525f,1760f,565f,1860f,p)

        p.color = Color.GRAY//horizon
        c.drawRect(0f,550f,1085f,1150f,p)

        p.color = Color.WHITE
        c.drawRect(0f,840f,80f,880f,p)
        c.drawRect(130f,840f,210f,880f,p)
        c.drawRect(840f,840f,940f,880f,p)
        c.drawRect(970f,840f,1070f,880f,p)

        if(active){
            sema.semat.start()
            hilo.start()
            active=false
        }

        carroy1.pintarCarro(c,0f,transY)
        carroy2.pintarCarro(c,0f,transY2)
        carrox1.pintarCarro(c,transX,0f)
        carrox2.pintarCarro(c,transX2,0f)
        invalidate()

    }

}//lienzo

