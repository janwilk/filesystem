package com.rtjvm.scala.oop.files

import com.rtjvm.scala.oop.filesystem.FileSystemException

class File(override val parentPath: String, override val name: String, contents: String)
  extends DirEntry(parentPath, name)  {
  override def asDirectory: Directory = throw new FileSystemException("A file cannot be converted into directory")
  override def getType: String = "file"
  override def asFile: File = this
  override def isDirectory: Boolean = false
  override def isFile: Boolean = true

  def contents(newContents: String, append: Boolean): File = {
    if (append) new File(parentPath, name, contents + "\n" + newContents)
    else new File(parentPath, name, newContents)
  }

  def getContents: String =
    contents
}

object File {
  def empty(parentPath: String, name: String): File =
    new File(parentPath, name, "")
}