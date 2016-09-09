#include "HelloWorld.h"

#ifdef __cplusplus
extern "C"
{
#endif
JNIEXPORT void JNICALL Java_HelloWorld_displayHelloWorld
  (JNIEnv *env, jobject obj){
	printf("hello robin");
}
