package lambdajam

object Boot extends Evaluator {
  val env = Map (
    "yo" -> Lit(20),
    "var" -> Var("yo"),
    "lit" -> Lit(12),
    //"apply" -> Apply(Lit(1), Lit(2)),
    // "apply" -> Apply(Lit(1), Lam("yo", Lit(100))),
    "apply" -> Apply(
      Lam(
        "a",
        Lit(25)
      ),
      Lit(10)
    ),
    "lam" -> Lam("lit", Lit(4)),
    "add-basic" -> Add(Lit(1), Lit(2)),
    "add-moar" -> Apply(
      Apply(
        Lam(
          "a",
          Lam(
            "b",
            Add(Var("a"), Var("b"))
          )
        ),
        Lit(10)
      ),
      Lit(20)
    )
  )

  println(eval(env)(Var("var")))
  println(eval(env)(Var("lit")))
  // println(eval(env)(Var("apply")))
  println(eval(env)(Var("lam")))
  println(eval(env)(Var("add-basic")))
  println(eval(env)(Var("add-moar")))
}
