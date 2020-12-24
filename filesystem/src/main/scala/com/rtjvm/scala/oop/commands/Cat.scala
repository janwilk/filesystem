package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.filesystem.{FileSystemException, State}

class Cat(filename: String) extends Command {
  override def apply(state: State): State = {
    val entry = state.wd.findEntry(filename)
    if (entry == null || !entry.isFile) state.setMessage(filename + ": no such file.")
    else state.setMessage(entry.asFile.getContents + "\n")
  }
}
