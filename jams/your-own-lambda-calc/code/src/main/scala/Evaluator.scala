package lambdajam

sealed trait Term
case class Var(v: String) extends Term
case class Lit(v: Int) extends Term
case class Apply(t1: Term, t2: Term) extends Term
case class Lam(s: String, t: Term) extends Term
case class Add(v1: Term, v2: Term) extends Term

class Evaluator extends App {
  def eval(env: Map[String, Term])(t: Term): Term = handleEval(env)(t)

  private[this] def logGet(env: Map[String, Term])(key: String) =
    try {
      env.get(key).get
    } catch {
      case err: Throwable =>
        println(s"Looking up `${key}` from ${env}, but failed.")
        throw err
    }

  private[this] def handleEval(env: Map[String, Term])(term: Term): Term = term match {
    case Var(k)        => handleEval(env)(logGet(env)(k))
    case Lit(_)        => term
    case Lam(s, t)     => handleEval(env)(t)

    // fancy maths
    case Add(v1, v2)   => (v1, v2) match {
      case (Lit(l1), Lit(l2)) => Lit(l1 + l2)
      case (ot, l@Lit(_)) => Add(l, handleEval(env)(ot))
      case (l@Lit(_), ot) => Add(handleEval(env)(ot), l)
      case (t1, t2) => Add(handleEval(env)(t1), handleEval(env)(t2))
    }

    case Apply(t1, t2) => (t1, t2) match {
      case (Apply(t3, t4), ot) => handleEval(env)(Apply(handleEval(env)(t3),
                                                        handleEval(env)(t4)))
      case (Lam(s, t), ot) =>
        val updated = env + (s -> handleEval(env)(ot))
        println(s"after2: ${updated}")
        eval(updated)(t)

      // uhh?
      case (Lit(x), Lit(y)) => Add(Lit(x), Lit(y))

      // rewrite / failure
      case (ot, Lam(s, t)) => handleEval(env)(Apply(Lam(s, t), ot))
      case (ot, Apply(t3, t4)) => handleEval(env)(Apply(Apply(t3, t4), ot))
      case bad => println(s"Bad = ${bad}"); ???
    }
  }
}
