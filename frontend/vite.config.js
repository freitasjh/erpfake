import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

// https://vitejs.dev/config/
export default defineConfig(() => {
    return {
        plugins: [vue()],
        resolve: {
            alias: {
                '@': fileURLToPath(new URL('./src', import.meta.url))
            }
        },
        server: {
            proxy:{
                '/erp':{
                    target: 'http://localhost:8082/api/',
                    changeOrigin: true,
                    rewrite: (path) => path.replace(/^\/erp/, ''),
                }
            }
        }
    };
});
