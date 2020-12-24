package com.rtjvm.scala.oop.commands

import com.rtjvm.scala.oop.files.{DirEntry, Directory}
import com.rtjvm.scala.oop.filesystem.State

import scala.annotation.tailrec

class Cd(dir: String) extends Command {
  override def apply(state: State): State = {
    val root = state.root
    val wd = state.wd
    val absolutePath = {
      if (dir.startsWith(Directory.SEPARATOR)) dir
      else if(wd.isRoot) wd.path + dir
      else wd.path + Directory.SEPARATOR + dir
    }

    val destiantionDirectory = doFindEntry(root, absolutePath)
    if (destiantionDirectory == null || !destiantionDirectory.isDirectory)
      state.setMessage(dir + ": no such directory")
    else State(root, destiantionDirectory.asDirectory)

  }

  def doFindEntry(root: Directory, path: String): DirEntry = {
    @tailrec
    def findEntryHelper(currentDirectory: Directory, path: List[String]): DirEntry = {
      if (path.isEmpty || path.head.isEmpty) currentDirectory
      else if (path.tail.isEmpty) currentDirectory.findEntry(path.head)
      else {
        val nextDir = currentDirectory.findEntry(path.head)
        if (nextDir == null || !nextDir.isDirectory) null
        else findEntryHelper(nextDir.asDirectory, path.tail)
      }
    }

    @tailrec
    def collapseRelativeTokens(path: List[String], result: List[String]): List[String] = {
      if (path.isEmpty) result
      else if (path.head.equals(Directory.CURRENT_DIRECTORY)) collapseRelativeTokens(path.tail, result)
      else if (!path.head.equals(Directory.PREVIOUS_DIRECTORY))
        collapseRelativeTokens(path.tail, result :+ path.head)
      else if (path.head.equals(Directory.PREVIOUS_DIRECTORY) && result.isEmpty)
        collapseRelativeTokens(path.tail, result)
      else collapseRelativeTokens(path.tail, result.dropRight(1))
    }

    val tokens: List[String] =
      path.substring(1)
        .split(Directory.SEPARATOR).toList

    val newTokens = collapseRelativeTokens(tokens, List())
    findEntryHelper(root, newTokens)
  }
}
