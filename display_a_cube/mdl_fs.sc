$input vNormal

#include <bgfx_shader.sh>

void main() {
	
	vec3 light_dir = normalize(vec3(1, -0.8, 0.5));
	vec4 ambient_color = vec4(0.2, 0.1, 0.3, 1.0);
	vec4 mainlight_color = vec4(1.0, 1.0, 1.0, 1.0);
	
	vec3 normal = normalize(vNormal);
	vec4 color = vec4(1.0, 1.0, 0.25, 1.0);

	float main_lighting = max(0.0, -dot(normal, light_dir));
	
	vec4 light_color = min(color * (mainlight_color * main_lighting ) + ambient_color, vec4(1.0, 1.0, 1.0, 1.0));
	
	gl_FragColor = light_color;
}
