#include <string.h>
#include <jni.h>
#include<stdlib.h>
#include <stdio.h>
#include <unistd.h>

#include <android/log.h>

#define LOGD(...) ((void)__android_log_print(ANDROID_LOG_DEBUG, "motion driver", __VA_ARGS__))

/**
 * 执行 shell 命令
 */
char* execute_cmd(const char* command);

/**
 * 根据不同参数执行 shell
 */
void go(int a, int b, int c, int d);

char* execute_cmd(const char* command)
{
    char* result = "";
    FILE *fpRead;
    fpRead = popen(command, "r");
    char buf[1024];
    memset(buf,'\0',sizeof(buf));
    while(fgets(buf,1024-1,fpRead)!=NULL)
    {
    	result = buf;
    }
    if(fpRead!=NULL)
        pclose(fpRead);
    return result;
}

void Java_com_jk_sixshot_motion_Motion_init( JNIEnv* env, jobject thiz )
{
	char* result;

	result = execute_cmd("su -c '(\
			echo 93 > /sys/class/gpio/export';\
			echo out > /sys/class/gpio/gpio93/direction;\
			echo 94 > /sys/class/gpio/export;\
			echo out > /sys/class/gpio/gpio94/direction;\
			echo 95 > /sys/class/gpio/export;\
			echo out > /sys/class/gpio/gpio95/direction;\
			echo 96 > /sys/class/gpio/export;\
			echo out > /sys/class/gpio/gpio96/direction\
			)");


	LOGD("init result is : %s", result);
}
//黄红蓝绿
//gpio96  黄  SPI0_MISO
//gpio93  红  SPI0_CLK
//gpio95  蓝  SPI0_MOSI
//gpio94  绿  SPI0_CS


void Java_com_jk_sixshot_motion_Motion_forward( JNIEnv* env, jobject thiz ){
	go(1, 0, 0, 1);
}

void Java_com_jk_sixshot_motion_Motion_backward( JNIEnv* env, jobject thiz ){
	go(0, 1, 1, 0);
}

void Java_com_jk_sixshot_motion_Motion_left( JNIEnv* env, jobject thiz ){
	go(1, 0, 0, 0);
}

void Java_com_jk_sixshot_motion_Motion_right( JNIEnv* env, jobject thiz ){
	go(0, 0, 0, 1);
}

void Java_com_jk_sixshot_motion_Motion_stop( JNIEnv* env, jobject thiz ){
	go(0, 0, 0, 0);
}

void go(int a, int b, int c, int d){
	char command[200];
	sprintf(command, "su -c '(\
			echo %d > /sys/class/gpio/gpio96/value;\
			echo %d > /sys/class/gpio/gpio93/value;\
			echo %d > /sys/class/gpio/gpio95/value;\
			echo %d > /sys/class/gpio/gpio94/value\
			)'", a, b, c, d);

	char* result = execute_cmd(command);

	LOGD("go result is : %s", result);
}


