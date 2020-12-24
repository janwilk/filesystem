package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{Directory, File}
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Echo(args: Array[String]) extends Command {
  override def apply(state: State): State = {
    if (args.isEmpty) state
    else if (args.length == 1) state.setMessage(args(0))
    else {
      val operator = args(args.length - 2)
      val filename = args(args.length - 1)
      val content = createContent(args, args.length - 2)

      if (operator.equals(">>"))
        doEcho(state, content, filename, append = true)
      else if (operator.equals(">"))
        doEcho(state, content, filename, append = false)
      else state.setMessage(createContent(args, args.length))
    }
  }

  def getRootAfterEcho(currentDirectory: Directory, path: List[String], contents: String, append: Boolean): Directory = {
    if (path.isEmpty) currentDirectory
    else if (path.tail.isEmpty) {
      val dirEntry = currentDirectory.findEntry(path.head)
      if (dirEntry == null) currentDirectory.addEntry(new File(currentDirectory.path, path.head, contents))
      else if (dirEntry.isDirectory) currentDirectory
      else currentDirectory.replaceEntry(path.head, dirEntry.asFile.contents(contents, append))
    }
    else {
      val nextDirectory = currentDirectory.findEntry(path.head).asDirectory
      val newNextDirectory = getRootAfterEcho(nextDirectory, path.tail, contents, append)

      if (newNextDirectory == nextDirectory) currentDirectory
      else currentDirectory.replaceEntry(path.head, newNextDirectory)
    }
  }

  def doEcho(state: State, contents: String, filename: String, append: Boolean): State = {
    if (filename.contains(Directory.SEPARATOR))
      state.setMessage("Echo: filename must not contain separators")
    else {
      val newRoot: Directory = getRootAfterEcho(state.root, state.wd.getAllFoldersInPath :+ filename, contents, append)
      if (newRoot == state.root)
        state.setMessage(filename + ": no such file")
      else
        State(newRoot, newRoot.findDescendant(state.wd.getAllFoldersInPath))
    }
  }


  def createContent(args: Array[String], topIndex: Int): String = {
    @tailrec
    def loop(currentIndex: Int, accumulator: String): String =
      if (currentIndex >= topIndex) accumulator
      else loop(currentIndex + 1, accumulator + " " + args(currentIndex))

    loop(0, "")
  }
}
