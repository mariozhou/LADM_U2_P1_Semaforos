package mx.tecnm.tepic.ladm_u2_p1_semaforo

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.util.concurrent.Semaphore

class Semaforo(l:Lienzo) {
    var semaforo = Semaphore(1)
    val act=l

    val semat = Thread(Runnable {
        while (true){
            val sema1 = Thread(Runnable {
                //semaVertical
                semaforo.acquireUninterruptibly()
                //ve
                act.c1 = "Black"
                act.c2 = "Black"
                act.c3 = "Green"
                act.semaV=true
                Thread.sleep(8400)
                //ama
                act.c2 = "Black"
                act.c2 = "Yellow"
                act.c3 = "Black"
                Thread.sleep(1000)
                //rojo
                act.semaV=false
                act.c1 = "Red"
                act.c2 = "Black"
                act.c3 = "Black"

                Thread.sleep(100)
                semaforo.release()

            }).start()

            Thread.sleep(200)
            val sema2 = Thread(Runnable {
                //semaHorizontal
                semaforo.acquireUninterruptibly()
                //ve
                act.semaH=true
                act.e1 = "Black"
                act.e2 = "Black"
                act.e3 = "Green"
                Thread.sleep(8400)
                //ama
                act.e1 = "Black"
                act.e2 = "Yellow"
                act.e3 = "Black"
                Thread.sleep(1000)
                //rojo
                act.e1 = "Red"
                act.e2 = "Black"
                act.e3 = "Black"
                act.semaH=false
                Thread.sleep(100)
                semaforo.release()


            }).start()
        }

    })//semat
}


