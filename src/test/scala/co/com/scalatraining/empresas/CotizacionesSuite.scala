package co.com.scalatraining.empresas

import org.scalatest.FunSuite

class CotizacionesSuite extends FunSuite {

  case class Cotizacion(){
    val archivo = List()


    def entrarDatos(año: Int, mes: Int, aportante: String, diasCotizados: Int, IBC: Long): Unit ={
        val list1 = List(año, mes, aportante, diasCotizados, IBC)
        archivo::list1
    }

    def IgnorarCotizaciones0()={

      val list1 = List()
      //list1 = archivo.foreach{ case(a,b,c,d,u) => u == 0

     // }

    }
  }

  test("Una List se debe poder construir") {

    val lista: List[Int] = List(1, 2, 3, 4)
    val lista2 = 1 :: 2 :: 3 :: 4 :: Nil
    assert(lista == lista2)
  }

}
