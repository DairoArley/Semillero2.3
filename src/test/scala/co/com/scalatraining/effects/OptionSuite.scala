package co.com.scalatraining.effects

import org.scalatest.FunSuite

import scala.collection.immutable.Seq

class OptionSuite extends FunSuite {

  test("Se debe poder crear un Option con valor"){
    val s = Option{
      1
    }
    assert(s == Some(1))
  }

  test("Se debe poder crear un Option con valor Some"){
    val s = Some{
      1
    }
    assert(s == Some(1))
  }

  test("Se debe poder crear un Option con valor Another"){
    val s = Some{
      null
    }
    assert(s == Some(null))
  }

  test("Se debe poder crear un Option con valor option null"){
    val s = Option{
      null
    }
    assert(s == None)
  }

  test("Se debe poder crear un Option para denotar que no hay valor"){
    val s = None
    assert(s == None)
  }

  test("Es inseguro acceder al valor de un Option con get"){
    val s = None
    assertThrows[NoSuchElementException]{
      val r = s.get
    }

  }

  test("Se debe poder hacer pattern match sobre un Option") {
    val lista: Seq[Option[String]] = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre: Option[String] = lista(1)
    var res = ""
    res = nombre match {
      case Some(nom) => nom
      case None => "NONAME"
    }
    assert(res == "NONAME")
  }

  test("Fold en Option"){
    val o = Option(1)

    val res: Int = o.fold{
      10
    }{
      x => x + 20
    }

    assert(res == 21)
  }

  test("Fold en Option y mas"){

    val o = Option(1)

    val res: Int = o.fold{
      10
    }{
      x => x + 20
    }

    assert(res == 21)
  }

  test("Se debe poder saber si un Option tiene valor con isDefined") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(0)
    assert(nombre.isDefined)
  }

  test("Se debe poder acceder al valor de un Option de forma segura con getOrElse") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(1)
    val res = nombre.getOrElse("NONAME")
    assert(res == "NONAME")
  }

  test("Se debe poder acceder al valor de un Option de forma segura con getOrElse con fold") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(1)
    //val res1 = nombre.fold()
    val res = nombre.getOrElse("NONAME")
    assert(res == "NONAME")
  }

  test("Un Option se debe poder transformar con un map") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(0)
    val nombreCompleto: Option[String] = nombre.map(s => s + " Felipe")
    assert(nombreCompleto.getOrElse("NONAME") == "Andres Felipe")
  }

  test("Un Option se debe poder transformar con flatMap en otro Option") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(0)

    val resultado: Option[String] = nombre.flatMap(s => Option(s.toUpperCase))
    resultado.map( s => assert( s == "ANDRES"))
  }

  test("Un Option se debe poder filtrar con una hof con filter") {
    val lista = List(Some(5), None, Some(40), Some(20))
    val option0 = lista(0)
    val option1 = lista(1)
    val res0 = option0.filter(_>10)
    val res1 = option1.filter(_>10)
    val res2 = option0.filter(_>10)

    assert(res0 == None)
    assert(res1 == None)
  }

  test("for comprehensions en Option") {
    val lista = List(Some(5), None, Some(40), Some(20))
    val s1 = lista(0)
    val s2 = lista(2)

    val resultado = for {
      x <- s1
      y <- s2
    } yield x+y

    assert(resultado == Some(45))
  }

  test ("otra") {
    def foo(n: Int): Option[Int] = {
      println(s"ejecutando foo con${n}")
      Some(n)
    }

    def bar(n: Int): Option[Int] = {
      println(s"ejecutando foo con${n}")
      None
    }

    val resultado = for {
      x <- foo(2)
      y <- foo(3)
      y <- bar(3)

    } yield x + y

    assert(resultado == None)
  }

  test("Este es nuevo"){

    val op1 = Some(1)
    val op2 = Some(2)
    val op3 = Some(3)

    val resultado = for {
      x <- op1
      y <- op2

    } yield x + y
  }


  test("for comprehensions en Option y uno mas") {
    val lista = List(Some(5), None, Some(40), Some(20))
    val s1 = lista(0)
    val s2 = lista(2)
    val s3 = lista(1)

    val resultado = for {
      x <- s1
      y <- s2
      z <- s3
    } yield x+y+z

    assert(resultado == None)
  }

  test("isDefined"){
    val nombre: Option[String]= Option("Dairo")
    val res = nombre match {
      case Some(name) => true
      case None => false
    }
    val res1 = nombre.isDefined
    assert(res===res1)
  }

  test("isEmpty"){

    val nombre: Option[String]= Option("Dairo")
    val res = nombre match {
      case Some(name) => false
      case None => true
    }
    val res1 = nombre.isEmpty
    assert(res===res1)
  }

  test("foreach"){
    val nombre: Option[String]= Option("Dairo")
    var name:String =""
    val resp:String = nombre match {
      case Some(nom) => nom
      case None => ""
    }
    nombre.foreach(x => name=x )
    assert(Some(name) === nombre)

  }

  /*test("forAll"){
    val nombre: Option[String]= Option("Dairo")

    val res = nombre match {
      case Some(nom) => nom
      case None => ""
    }
    nombre.foreach(x => name=x )
    assert(Some(name) === nombre)

  }*/

  test("for comprehesions None en Option") {
    val consultarNombre = Some("Andres")
    val consultarApellido = Some("Estrada")
    val consultarEdad = None
    val consultarSexo = Some("M")

    val resultado = for {
      nom <- consultarNombre
      ape <- consultarApellido
      eda <- consultarEdad
      sex <- consultarSexo
    //} yield (nom+","+ape+","+eda+","+sex)
    } yield (s"$nom $ape, $eda,$sex")

    assert(resultado == None)
  }

  test("for comprehesions None en Option 2") {

    def consultarNombre(dni:String): Option[String] = Some("Felix")
    def consultarApellido(dni:String): Option[String] = Some("Vergara")
    def consultarEdad(dni:String): Option[String] = None
    def consultarSexo(dni:String): Option[String] = Some("M")

    val dni = "8027133"
    val resultado = for {
      nom <- consultarNombre(dni)
      ape <- consultarApellido(dni)
      eda <- consultarEdad(dni)
      sex <- consultarSexo(dni)
    //} yield (nom+","+ape+","+eda+","+sex)
    } yield (s"$nom $ape, $eda,$sex")

    assert(resultado == None)
  }

}

