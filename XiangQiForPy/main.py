# -*- coding:utf-8 -*-
import jpype

jvm_path = jpype.getDefaultJVMPath()
jpype.startJVM(jvm_path,
               '-ea',
               '-Djava.class.path=%s' % './lib/xiangqi.jar')
jclass = jpype.JClass('com.Test')  # 加载类
calc = jclass()# 传入所需参数
calc.test()
jpype.shutdownJVM()  # 关闭JAVA虚拟机