#include <stdio.h>
#include "MyNative.h"
JNIEXPORT void JNICALL Java_MyNative_showParms0
  (JNIEnv *env, jobject obj, jstring s, jint i, jboolean b)
{
  const char* szStr = (*env)->GetStringUTFChars( env, s, 0 );
  printf( "String = [%s]\n", szStr );
  printf( "int = %d\n", i );
  printf( "boolean = %s\n", (b==JNI_TRUE ? "true" : "false") );
  (*env)->ReleaseStringUTFChars( env, s, szStr );
}