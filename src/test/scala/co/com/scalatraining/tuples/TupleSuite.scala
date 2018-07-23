package co.com.scalatraining.tuples

import org.scalatest.FunSuite

class TupleSuite  extends FunSuite {

  test("Una tupla se debe poder crear"){
    val tupla = (1, 2,"3", List(1, 2, 3))
    assert(tupla._2 == 2)
    assert(tupla._4.tail.head == 2)
  }

  test("tuplas"){
    val tupla = (List(1,2,3),List(1,2,3),List(1,2,3),List(1,2,3),List(1,2,3))
    val tupla2 = (tupla._1.head, tupla._2.head, tupla._3.head,tupla._4.head,tupla._5.head)
    assert(tupla2 == (1,1,1,1,1))

  }
  test("promedio"){
    val lista = List(1, 2, 3, 4, 6, 7, 8, 9, 10)
      assertResult(6){
      lista.fold(0){ (acumulado, item) =>
        (acumulado / item)
      }
    }

    test("Map"){
      val lista = List("hola", "ya", "yo", "sisas")
      val lista2 = lista.map(dato => dato.size)

      assert(lista2 == List(4,2,2,5))

    }

  }



}
