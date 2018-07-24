package co.com.scalatraining.collections

import org.scalatest.FunSuite

import scala.collection.immutable.Queue

class QueueSuite extends FunSuite {

  test("Se puede retornar el enèsimo elemento de la cola"){
    val cola = Queue(1,2,3,4)
    val ultimo = cola.apply(3)

    assert(ultimo == 4)
  }


  test("Se puede preguntar si existe un elemento en la cola"){
    val cola = Queue(1,2,3,4)
    val bool = cola.contains(4)

    assert(bool == true)
  }

  test("Se puede eliminar varias elementos del inicio de la cola"){
    val cola = Queue(1,2,3,4)
    val cola2 = cola.drop(3)

    assert(cola2 == Queue(4))
  }

}
