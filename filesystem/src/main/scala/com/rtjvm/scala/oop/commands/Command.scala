package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.State

trait Command {
  def apply(state: State): State
}

object Command {
  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"
  val CD = "cd"
  val RM = "rm"
  val ECHO = "echo"
  val CAT = "cat"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state.setMessage("")
  }

  def incompleteCommand(name: String): Command = new Command {
    override def apply(state: State): State = state.setMessage(name + ": incomplete command ")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) return emptyCommand
    tokens match {
      case Array(command) =>
        command match {
          case MKDIR => incompleteCommand(MKDIR)
          case LS => new Ls
          case PWD => new Pwd
          case CD => incompleteCommand(CD)
          case RM => incompleteCommand(RM)
          case ECHO => incompleteCommand(ECHO)
          case CAT => incompleteCommand(CAT)
          case _ => new UnknownCommand
        }
      case Array(command, arg) =>
        command match {
          case MKDIR => new Mkdir(arg)
          case TOUCH => new Touch(arg)
          case CD => new Cd(arg)
          case RM => new Rm(arg)
          case ECHO => new Echo(Array(arg))
          case CAT => new Cat(arg)
        }
      case Array(command, _*) =>
        command match {
          case ECHO => new Echo(tokens.tail)
        }
    }
  }
}
