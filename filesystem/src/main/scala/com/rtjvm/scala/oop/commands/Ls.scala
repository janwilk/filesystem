package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.DirEntry
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Ls extends Command {
  override def apply(state: State): State = {
    @tailrec
    def displayContent(content: List[DirEntry], display: String): String = {
      if (content.isEmpty) display
      else if (content.head.getType == "file") displayContent(content.tail, display.concat(s"${content.head.name}\n"))
      else displayContent(content.tail, display.concat(s"[${content.head.name}]\n"))
    }
    state.setMessage(displayContent(state.wd.contents, ""))
  }
}
